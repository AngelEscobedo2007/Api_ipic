package ipic.api;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc
class IpicControllerTests {
 @Autowired MockMvc mock;
 @Test void saludRespondeOk() throws Exception {
   mock.perform(get("/api/salud")).andExpect(status().isOk()).andExpect(jsonPath("$.estado").value("ok"));
 }
 @Test void altaYConsultaAlumno() throws Exception {
  String body="{\"matricula\":\"TEST-001\",\"nombre\":\"Angel\",\"apellidoPaterno\":\"Escobedo\",\"semestre\":3,\"genero\":\"Masculino\"}";
  mock.perform(post("/api/alumnos").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isCreated()).andExpect(jsonPath("$.matricula").value("TEST-001"));
  mock.perform(get("/api/alumnos/TEST-001")).andExpect(status().isOk()).andExpect(jsonPath("$.nombre").value("Angel"));
 }
}