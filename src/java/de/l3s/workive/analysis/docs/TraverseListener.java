package de.l3s.workive.analysis.docs;

import java.io.File;

public interface TraverseListener {

	public void directoryFound(File examine);

	public void fileFound(File examine);

}
