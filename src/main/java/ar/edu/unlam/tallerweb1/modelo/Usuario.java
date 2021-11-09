package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en el
@Entity
@Table(name = "usuario")
public class Usuario {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String rol;
	private String nombre;
	private String apellido;
	private String fechaSancion;

	@ManyToOne
	private Equipo equipo;

	@ManyToMany(fetch=FetchType.LAZY, mappedBy = "usuarios")
	private Set<Partido> partidos = new HashSet<Partido>();

	public Usuario(){}

	public Usuario(String email, String password, String rol, String nombre, String apellido) {
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.nombre = nombre;
		this.apellido = apellido;

	}

	public Usuario(String email, String password, String rol, String nombre, String apellido, String fechaSancion) {
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaSancion = fechaSancion;
	}

	private Boolean activo = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public boolean activo() {
		return activo;
    }

    public void activar() {
		activo = true;
    }

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getApellido() {return apellido;}

	public void setApellido(String apellido) {this.apellido = apellido;}

	public String getFechaSancion() {
		return fechaSancion;
	}

	public void setFechaSancion(String fechaSancion) {
		this.fechaSancion = fechaSancion;
	}

	public Set<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(Set<Partido> partidos) {
		this.partidos = partidos;
	}

	public Boolean agregarPartido(Partido partido){
		return this.partidos.add(partido);
	}
}
