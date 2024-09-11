import java.util.Scanner;

public class ParcialArtistasBarrio 
{
	public static void main(String[] args) 
	{
		//Gobierno evalúa estadísticas relevantes 
		//(presupuesto destinado a la pintura de cada barrio, tiempos de ejecución, y otros).
		
		//Un grupo de artistas pintarán 10 barrios. Cada barrio varía en su cant de artistas
		//puede que haya barrios sin artistas. Cada uno puede pintar solo una obra.
		//Cada artista estimará la cant de pintura en aerosol requerida y las horas necesarias.
		
		Scanner scanner = new Scanner(System.in);
		//Estimaciones artistas (acumuladores)
		int pinturaNecesariaTotalBarrio = 0;
		int pinturaTotal = 0;
		int horasNecesariasTotalBarrio = 0; 
		
		//Artista que necesita mas pintura
		String artistaMaxPintura = "temp";
		int maxPintura = 0;
		
		//Contador de artista por barrio.
		int artistasEnBarrio = 0;  
		
		//Creamos los 10 barrios.
		for(int i = 0; i < 10; i++) 
		{
			System.out.println("Ingresa el nombre del barrio " + (i + 1));
			String nombreBarrio = scanner.nextLine();
			
			//Pediremos los datos del artista que pintará el barrio (un dato fuera del while y los otros dos dentro).
			System.out.println("Ingresa el nombre del artista.");
			String nombreArtista = scanner.nextLine();

			while(!(nombreArtista.equals("FIN"))) //Al introducir fin en nombreArtista se acaban los artistas por el barrio.
			{
				System.out.println("Ingresa una estimación de las horas que necesitará (mayor a 0)");
				int horasEstimadasNecesarias = scanner.nextInt();
				
				while(horasEstimadasNecesarias <= 0) //Verificamos que las horas ingresadas sean mayor a 0. 
				{
					System.out.println("La cantidad de horas necesarias debe ser mayor a 0.");
					horasEstimadasNecesarias = scanner.nextInt();
				}
				
				System.out.println("Ingresa en milímetros una estimación de la pintura que necesitará (mayor a 0)");
				int pinturaEstimadaNecesaria = scanner.nextInt();
				
				while(pinturaEstimadaNecesaria <= 0) //Verificamos que la pintura necesaria sea mayor a 0. 
				{
					System.out.println("La pintura necesaria debe ser mayor a 0.");
					pinturaEstimadaNecesaria = scanner.nextInt();
				}
				
				//Acumulamos las horas y pintura necesaria de los artistas por el barrio.
				horasNecesariasTotalBarrio += horasEstimadasNecesarias;
				pinturaNecesariaTotalBarrio += pinturaEstimadaNecesaria;
				
				//Evaluamos si la pintura de este artista es la mayor hasta ahora.
				if(pinturaEstimadaNecesaria > maxPintura) 
				{
					maxPintura = pinturaEstimadaNecesaria;
					artistaMaxPintura = nombreArtista;
				}
				
				//Se ingresaron los 3 datos correctamente agregaremos este artista al contador.
				artistasEnBarrio++;
				
				//Usuario ingresa otro art o continúa con otro barrio.
				System.out.println("Ingresa el siguiente artista del barrio o FIN para continuar con los artistas del siguiente barrio.");
				nombreArtista = scanner.nextLine();
				nombreArtista = scanner.nextLine();
			} //FIN BARRIO
			
			//Almacenamos la pintura total para el total de las obras.
			pinturaTotal += pinturaNecesariaTotalBarrio; //Acumulador para devolverse al final del programa.
			
			//Convertimos los milimetros a litros.
			double promedioPinturaPorObra = pinturaNecesariaTotalBarrio / artistasEnBarrio;
			
			System.out.println("Total de horas necesarias en el barrio: " + horasNecesariasTotalBarrio);
			System.out.println("Promedio de pintura por obra en el barrio: " + promedioPinturaPorObra);
			System.out.println(" ");
			
			//Reiniciamos las variables correspondientes para evitar problemas
			artistasEnBarrio = 0; 
			horasNecesariasTotalBarrio = 0;
			pinturaNecesariaTotalBarrio = 0;
			
		} //FIN PROGRAMA
		
		double pinturaTotalLitros = pinturaTotal / 1000.0; //Convertimos los milimetros totales a litros.
		System.out.println("Pintura necesaria para el total de las obras (en litros): " + pinturaTotalLitros);
		System.out.println("Artista que necesitó más pintura " + artistaMaxPintura);
	}
}
