package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class RepositorioTest extends SpringTest {

    @Test
    @Transactional
    @Rollback
    public void repo(){

    }
}
