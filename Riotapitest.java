	import java.io.BufferedReader;
	import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
	import java.nio.file.FileSystems;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.util.Scanner;

	import net.rithms.riot.api.ApiConfig;
	import net.rithms.riot.api.RiotApi;
	import net.rithms.riot.api.RiotApiException;
	import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
	import net.rithms.riot.constant.Platform;

public class Riotapitest {

		public static void main(String[] args) throws RiotApiException, IOException {
			
			String summonerName;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter a Summoner Name: ");
		    summonerName = reader.readLine();
		    
			String key = null;
						
			Path file = FileSystems.getDefault().getPath(args[0]);
		    Charset charset = Charset.forName("US-ASCII");

			try (BufferedReader reader1 = Files.newBufferedReader(file, charset)) {
				String line = null;
				if ((line = reader1.readLine()) != null)
					key = line;
				
			}
			
			ApiConfig config = new ApiConfig().setKey(key);

			RiotApi api = new RiotApi(config);

			Summoner summoner = api.getSummonerByName(Platform.EUW, summonerName);

			System.out.println("Name: " + summoner.getName());
			System.out.println("Level: " + summoner.getSummonerLevel());
			
		}
	}