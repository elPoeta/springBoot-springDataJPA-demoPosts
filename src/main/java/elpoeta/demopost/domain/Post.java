package elpoeta.demopost.domain;



import java.time.LocalDateTime;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import elpoeta.demopost.json.JsonDateSerializer;



@Entity

public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String subTitulo;
	private String cuerpo;
	private LocalDateTime fechaCreacion;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Autor autor;

    @ElementCollection
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name= "post_id"))
    @Column(name = "tag")
    private Set<String> tags;

	public Post() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}
	

	public String getCuerpo() {
		return this.cuerpo;
	}


	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	
	public void setCuerpo(String cuerpo) {

		this.cuerpo = cuerpo;
	}

	@JsonSerialize(using=JsonDateSerializer.class) 
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
	
	
	
	
	
}
