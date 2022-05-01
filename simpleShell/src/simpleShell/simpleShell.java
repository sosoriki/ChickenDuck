package simpleShell;
import java.io.*;
public class simpleShell {
	private String[] history = new String[4];
	public static void main(String[] args) throws Exception{
		String command;
		BufferedReader console = new BufferedReader (new InputStreamReader(System.in));
		ProcessBuilder pb = new ProcessBuilder();
		while(true) {
			System.out.printf("jsh> ");
			command = console.readLine();
			if(command.equals("")) {
				continue;
			}
			if(command.equals("clear")) {
				for(int i = 0; i < 10; i++) {
					System.out.printf("");
				}
			}
			if(command.endsWith("Java")) {
				if (command.startsWith("cat")) {
					pb.command(command);
				}
				else{
					System.out.printf("Invalid Command\n");
				}
			}
			if(command.contains("cd")) {
				if(command.matches("cd") == true) {
					File home = new File(System.getProperty("user.home"));
					System.out.printf("Home Directory: %s\n", home);
					pb.directory(home);
					continue;
				}
				else {
					String directory = command;
					String path = pb.directory() + "\\" + directory;
					File newPath = new File(path);
					pb.directory(newPath);
					System.out.printf("New Path created at %s\n", path);
					continue;
				}
			}
			if(command.equals("exit")) {
				System.out.printf("Terminating...\n");
				System.exit(0);
			}
			pb.start();
		}
	}

}
