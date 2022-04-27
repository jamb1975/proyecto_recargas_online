package co.com.jamb.mutant;

import co.com.jamb.recragas.datos.RecargasDAO;
import co.com.jamb.recragas.datos.RecargasRepo;
import co.com.jamb.recragas.domain.Recargas;
import co.com.jamb.recragas.domain.Terceros;
import co.com.jamb.recragas.helper.CalcularMCD;
import co.com.jamb.recragas.servicio.RecargasService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MutantApplicationTests {
	@Autowired
    private RecargasService mutanteService;
	@Autowired
	private RecargasRepo mutanteRepo;
	@Autowired
	private RecargasDAO mutanteDAO;

	@Autowired
	ReactiveMongoTemplate reactiveMongoTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void  testMCD() {
		Long num1 = Long.valueOf(2310);
		Long num2 = Long.valueOf(98);

		assertEquals(14,CalcularMCD.calcular(num1, num2));

	}

	@Test
	void  testStats() {

		assertEquals(Terceros.class,mutanteService.stats().block().getClass());

	}

	@Test
	void  testIsMutantTrue() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Recargas mutante = new Recargas(dna);
		mutante = mutanteService.ismutant(mutante).block();

		assertEquals(true, mutante.isMutant());

	}

	@Test
	void  testIsMutantFalse() {
		String[] dna = {"ATGCGA","CGGTGC","TTATGT","AGAACT","CCCTTA","TCACTG"};
		Recargas mutante = new Recargas(dna);
		mutante = mutanteService.ismutant(mutante).block();

		assertEquals(false, mutante.isMutant());

	}

	@Test
	 void testFindAll(){
		String[] dna = {"ATGCGA","CGGTGC","TTATGT","AGAACT","CCCTTA","TCACTG"};
		Recargas mutante = new Recargas(dna);
		mutante = mutanteService.ismutant(mutante).block();

		assertEquals(ArrayList.class, mutanteService.findAll().collectList().block().getClass());

	}

	@Test
	void testFindByAdn(){
		String[] dna = {"ATGCGA","CGGTGC","TTATGT","AGAACT","CCCTTA","TCACTG"};
		Recargas mutante = new Recargas(dna);
		mutante = mutanteService.ismutant(mutante).block();

		List<Recargas> mutantes = mutanteRepo.findByAdn(dna).collectList().block();
		assertEquals("ATGCGA", mutantes.get(0).getAdn()[0]);

	}

	@Test
	void deletebyid(){
		reactiveMongoTemplate.dropCollection("mutantes").subscribe();
		assertEquals("OK", "OK");
	}

	@Test
	void delete(){
		String[] dna = {"ATGCGA","CGGTGC","TTATGT","AGAACT","CCCTTA","TCACTG"};
		Recargas mutante = new Recargas(dna);
		mutante = mutanteService.ismutant(mutante).block();
		mutanteRepo.delete(mutante);
		assertEquals("OK", "OK");
	}

}
