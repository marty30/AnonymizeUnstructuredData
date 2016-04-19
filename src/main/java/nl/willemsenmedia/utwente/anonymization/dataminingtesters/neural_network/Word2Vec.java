package nl.willemsenmedia.utwente.anonymization.dataminingtesters.neural_network;

import org.canova.api.records.reader.RecordReader;
import org.canova.api.records.reader.impl.CSVRecordReader;
import org.canova.api.split.FileSplit;
import org.deeplearning4j.datasets.canova.RecordReaderDataSetIterator;
import org.deeplearning4j.datasets.iterator.DataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.deeplearning4j.ui.UiServer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collection;

/**
 * Created by Martijn on 14-4-2016.
 */
public class Word2Vec {
	private static Logger log = LoggerFactory.getLogger(Word2Vec.class);

	public static void mainTxt(String[] args) throws Exception {

		String filePath = new File("C:\\Users\\Martijn\\Dropbox\\Studie\\College\\Module11&12\\ResearchProject-Ynformed\\JavaApplicatie\\AnonimizeUnstructuredData\\SFU_Review_Corpus.csv").getAbsolutePath();

		log.info("Load & Vectorize Sentences....");
		// Strip white space before and after for each line
		SentenceIterator iter = new BasicLineIterator(filePath);
		// Split on white spaces in the line to get words
		TokenizerFactory t = new DefaultTokenizerFactory();
		t.setTokenPreProcessor(new CommonPreprocessor());

		log.info("Building model....");
		org.deeplearning4j.models.word2vec.Word2Vec vec = new org.deeplearning4j.models.word2vec.Word2Vec.Builder()
				.minWordFrequency(5)
				.iterations(1)
				.layerSize(100)
				.seed(42)
				.windowSize(5)
				.iterate(iter)
				.tokenizerFactory(t)
				.build();

		log.info("Fitting Word2Vec model....");
		vec.fit();

		log.info("Writing word vectors to text file....");

		// Write word vectors
		WordVectorSerializer.writeWordVectors(vec, "pathToWriteto.txt");

		log.info("Closest Words:");
		Collection<String> lst = vec.wordsNearest("day", 10);
		System.out.println(lst);
		UiServer server = UiServer.getInstance();
		System.out.println("Started on port " + server.getPort());
	}

	public static void mainCsv(String[] args) throws Exception {

		//First: get the dataset using the record reader. CSVRecordReader handles loading/parsing
		int numLinesToSkip = 0;
		String delimiter = ",";
		RecordReader recordReader = new CSVRecordReader(numLinesToSkip, delimiter);
		recordReader.initialize(new FileSplit(new File(Word2Vec.class.getClassLoader().getResource("SFU_Review_Corpus.csv").getFile())));

		//Second: the RecordReaderDataSetIterator handles conversion to DataSet objects, ready for use in neural network
		int labelIndex = 4;     //5 values in each row of the iris.txt CSV: 4 input features followed by an integer label (class) index. Labels are the 5th value (index 4) in each row
		int numClasses = 3;     //3 classes (types of iris flowers) in the iris data set. Classes have integer values 0, 1 or 2
		int batchSize = 150;    //Iris data set: 150 examples total. We are loading all of them into one DataSet (not recommended for large data sets)
		DataSetIterator iterator = new RecordReaderDataSetIterator(recordReader, batchSize, labelIndex, numClasses);


		DataSet next = iterator.next();

		final int numInputs = 4;
		int outputNum = 3;
		int iterations = 1000;
		long seed = 6;


		log.info("Build model....");
		MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
				.seed(seed)
				.iterations(iterations)
				.learningRate(0.1)
				.regularization(true).l2(1e-4)
				.list(3)
				.layer(0, new DenseLayer.Builder().nIn(numInputs).nOut(3)
						.activation("tanh")
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(1, new DenseLayer.Builder().nIn(3).nOut(3)
						.activation("tanh")
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(2, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
						.weightInit(WeightInit.XAVIER)
						.activation("softmax")
						.nIn(3).nOut(outputNum).build())
				.backprop(true).pretrain(false)
				.build();

		//run the model
		MultiLayerNetwork model = new MultiLayerNetwork(conf);
		model.init();
		model.setListeners(new ScoreIterationListener(100));

		//Normalize the full data set. Our DataSet 'next' contains the full 150 examples
		next.normalizeZeroMeanZeroUnitVariance();
		next.shuffle();
		//split test and train
		SplitTestAndTrain testAndTrain = next.splitTestAndTrain(0.65);  //Use 65% of data for training

		DataSet trainingData = testAndTrain.getTrain();
		model.fit(trainingData);

		//evaluate the model on the test set
		Evaluation eval = new Evaluation(3);
		DataSet test = testAndTrain.getTest();
		INDArray output = model.output(test.getFeatureMatrix());
		eval.eval(test.getLabels(), output);
		log.info(eval.stats());
	}

	public static void main(String[] args) throws Exception {
		mainTxt(args);
	}
}