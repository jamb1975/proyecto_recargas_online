	package co.com.jamb.recragas;

	import co.com.jamb.recragas.datos.RecargasDAO;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;

	@SpringBootApplication
	//@EnableReactiveMongoRepositories(basePackages = "co.com.jamb.mutant.datos")
	public class RecargarApplication implements CommandLineRunner {
		@Autowired
		private RecargasDAO mutanteDAO;
		//@Autowired
		//ReactiveMongoTemplate reactiveMongoTemplate;
		private static final Logger log = LoggerFactory.getLogger(RecargarApplication.class);
		public static void main(String[] args) {
			SpringApplication.run(RecargarApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			/*reactiveMongoTemplate.dropCollection("mutantes").subscribe();
			String [ ] as ={"ATGCGA-CAGTGC-TTATGT-AGAAGG-CCCCTA-TCACTG"};
			String [ ] as2 ={"ATGCTA-CAGTGC-TTATGT-AGAAGG-CCCCTA-TCACTG"};
			Flux.just(new Mutante(as),
					  new Mutante(as2)
			)
			.flatMap(mutanteDAO::save)
			.subscribe(m->log.info("Insert" + m.getId() + " " + m.getAdn()));*/
		}
	}
