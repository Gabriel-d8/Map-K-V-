package exercici;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> mapVotes = new LinkedHashMap<>();
		
		System.out.print("Enter file full path which are stored the votes of the candidates: ");	
		String path = sc.next();
		
		System.out.println();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while (line != null) {
				String fields[] = line.split(",");
				String name = fields[0];
				Integer count = Integer.parseInt(fields[1]);
				
				if (mapVotes.containsKey(name)) {
					int votesSoFar = mapVotes.get(name);
					mapVotes.put(name, count + votesSoFar);
				}
				else {
					mapVotes.put(name, count);
				}
				
				line = br.readLine();
				
			}
			
			System.out.println("Below are the names and number of votes for each candidate:");
			
			for (String key : mapVotes.keySet()) {
				System.out.println(key + ": " + mapVotes.get(key));
			}
			
			
		} catch (IOException e) {
			System.out.println("Error!" + e.getMessage());
		}

		sc.close();
		
	}

}