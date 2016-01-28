package easyclips;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import net.sf.clipsrules.jni.*;

public class Main {
	boolean initialised = false;
	Environment clips;
	
	public void run() {
		init();
		
		String CONDITION_DIR = "resources/condition.clp";
		String COMMAND_DIR = "resources/command.clp";
		
		String condition = "";
		try {
			condition = new String(Files.readAllBytes(Paths.get(CONDITION_DIR)));
			clips.loadFromString(condition);
			clips.run();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(COMMAND_DIR));
			String command = null;
			while ((command = br.readLine()) != null) {
				System.out.println(clips.eval(command));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	
	public void init() {
		if (!initialised) clips = new Environment();
		else clips.reset();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Main problem = new Main();
		
		while (true) {
			System.out.print("Press Enter to execute...");
			scan.nextLine();
			problem.run();
		}
	}
}
