package nl.willemsenmedia.utwente.anonymization.dataminingtesters.svm;

import libsvm.*;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by Martijn on 19-4-2016.
 */
public class SVMClassifier {
	private svm_parameter param;

	public SVMClassifier() {
		param = new svm_parameter();
		param.svm_type = svm_parameter.NU_SVC;
		param.degree = 3;
		param.gamma = 0;    // 1/num_features
		param.coef0 = 0;
		param.nu = 0.5;
		param.cache_size = 100;
		param.C = 1;
		param.eps = 1e-3;
		param.p = 0.1;
		param.shrinking = 1;
		param.probability = 0;
		param.nr_weight = 0;
		param.weight_label = new int[0];
		param.weight = new double[0];
	}

	public static File convertCSVToLibsvm(File inputfile) throws FileNotFoundException {
		File libsvm = new File(inputfile.getAbsolutePath().substring(inputfile.getAbsolutePath().lastIndexOf("/")) + ".libsvm");
		PrintStream out = new PrintStream(libsvm);
		//read everything from csv

		// tokenize each entry

		// create vocabulary

		// write each entry to the output

		return libsvm;
	}

	private static double atof(String s) {
		double d = Double.valueOf(s);
		if (Double.isNaN(d) || Double.isInfinite(d)) {
			System.err.print("NaN or Infinity in input\n");
			System.exit(1);
		}
		return (d);
	}

	private static int atoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		new SVMClassifier().run(new File("C:\\Users\\Martijn\\Dropbox\\Studie\\College\\Module11&12\\ResearchProject-Ynformed\\JavaApplicatie\\AnonimizeUnstructuredData\\test.libsvm"));
	}

	private void run(File inputfile) throws IOException {
		if (inputfile.getAbsolutePath().endsWith(".csv")) {
			inputfile = convertCSVToLibsvm(inputfile);
		}
		svm_problem prob = build_problem(read_file(inputfile));
		String error_msg = svm.svm_check_parameter(prob, param);
		File log = File.createTempFile("log", ".txt");
		PrintStream out = new PrintStream(log);
		svm.svm_set_print_string_function(out::println);
		if (error_msg != null) {
			System.err.print("ERROR: " + error_msg + "\n");
			System.exit(1);
		}
		svm_model model = svm.svm_train(prob, param);
		double[] target = new double[prob.l];
		svm.svm_cross_validation(prob, param, 10, target);
		int total_correct = 0;
		for (int i = 0; i < prob.l; i++)
			if (target[i] == prob.y[i])
				++total_correct;
		System.out.print("Cross Validation Accuracy = " + 100.0 * total_correct / prob.l + "%\n");
		System.out.println("Printed log to: " + log.getAbsolutePath());
	}

	public svm_file read_file(File input_file_name) throws IOException {
		svm_problem prob;
		BufferedReader fp = new BufferedReader(new FileReader(input_file_name));
		Vector<Double> vy = new Vector<Double>();
		Vector<svm_node[]> vx = new Vector<svm_node[]>();
		int max_index = 0;

		while (true) {
			String line = fp.readLine();
			if (line == null) break;

			StringTokenizer st = new StringTokenizer(line, " \t\n\r\f:");

			vy.addElement(atof(st.nextToken()));
			int m = st.countTokens() / 2;
			svm_node[] x = new svm_node[m];
			for (int j = 0; j < m; j++) {
				x[j] = new svm_node();
				x[j].index = atoi(st.nextToken());
				x[j].value = atof(st.nextToken());
			}
			if (m > 0) max_index = Math.max(max_index, x[m - 1].index);
			vx.addElement(x);
		}
		fp.close();

		return new svm_file(vy, vx, max_index);
	}

	public svm_problem build_problem(svm_file svm_file) {
		Vector<Double> vy = svm_file.getVy();
		Vector<svm_node[]> vx = svm_file.getVx();
		int max_index = svm_file.getMax_index();
		svm_problem prob = new svm_problem();
		prob.l = vy.size();
		prob.x = new svm_node[prob.l][];
		for (int i = 0; i < prob.l; i++)
			prob.x[i] = vx.elementAt(i);
		prob.y = new double[prob.l];
		for (int i = 0; i < prob.l; i++)
			prob.y[i] = vy.elementAt(i);

		if (param.gamma == 0 && max_index > 0)
			param.gamma = 1.0 / max_index;

		if (param.kernel_type == svm_parameter.PRECOMPUTED)
			for (int i = 0; i < prob.l; i++) {
				if (prob.x[i][0].index != 0) {
					System.err.print("Wrong kernel matrix: first column must be 0:sample_serial_number\n");
					System.exit(1);
				}
				if ((int) prob.x[i][0].value <= 0 || (int) prob.x[i][0].value > max_index) {
					System.err.print("Wrong input format: sample_serial_number out of range\n");
					System.exit(1);
				}
			}


		return prob;
	}

	private class svm_file extends svm_problem {
		private final Vector<Double> vy;
		private final Vector<svm_node[]> vx;
		private final int max_index;

		public svm_file(Vector<Double> vy, Vector<svm_node[]> vx, int max_index) {
			this.vy = vy;
			this.vx = vx;
			this.max_index = max_index;
		}

		public Vector<Double> getVy() {
			return vy;
		}

		public Vector<svm_node[]> getVx() {
			return vx;
		}

		public int getMax_index() {
			return max_index;
		}
	}
}