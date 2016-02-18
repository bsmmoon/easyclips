package easyclips;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import net.sf.clipsrules.jni.*;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	
	private boolean initialised = false;
	private Environment clips;
	
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

		String command = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(COMMAND_DIR));
			while ((command = br.readLine()) != null) {
				System.out.println("CLIPS> " + command);
				System.out.println(clips.eval(command));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		while (true) {
			System.out.print("CLIPS> ");
			command = scan.nextLine();
			if (command.equals("exit")) break;
			System.out.println(clips.eval(command));
		}
	}
	
	public void init() {
		if (!initialised) clips = new Environment();
		else clips.reset();
	}

	public static void main(String[] args) {
		Main problem = new Main();
		
		while (true) {
			System.out.println();
			System.out.println("////////// Session Starts //////////");
			System.out.print("Press Enter to execute...");
			scan.nextLine();
			problem.run();
			System.out.println("//////////  Session Ends  //////////");
		}
	}
}
