package nl.willemsenmedia.utwente.anonymization.data.reading;

import nl.willemsenmedia.utwente.anonymization.data.DataEntry;
import nl.willemsenmedia.utwente.anonymization.settings.Settings;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Martijn on 29-3-2016.
 */
public class DirReader {
	public static List<DataEntry> readDir(File directory, Settings settings) {
		if (directory != null && directory.isDirectory()) {
			LinkedList<DataEntry> list = new LinkedList<>();
			for (File file : directory.listFiles()) {
				list.addAll(FileReader.readFile(file, settings));
			}
			return list;
		} else {
			return FileReader.readFile(directory, settings);
		}
	}
}
