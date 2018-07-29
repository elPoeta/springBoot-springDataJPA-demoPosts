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
		if(titulo == "" || titulo == null) {
			throw new IllegalArgumentException("El titulo esta vacio");
		}
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		
		if(subTitulo == "" || subTitulo == null) {
			throw new IllegalArgumentException("El subtitulo esta vacio");
		}
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
		if(cuerpo == "" || cuerpo == null) {
			throw new IllegalArgumentException("El cuerpo esta vacio");
		}
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
		if(categoria.getId() == null) {
			throw new IllegalArgumentException("El id categoria esta vacio");
		}
		this.categoria = categoria;
	}

	public Autor getAutor() {
		
		return autor;
	}
	

	public void setAutor(Autor autor) {
		if(autor.getId() == null) {
			throw new IllegalArgumentException("El id del autor esta vacio");
		}
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", titulo=" + titulo + ", subTitulo=" + subTitulo + ", cuerpo=" + cuerpo
				+ ", fechaCreacion=" + fechaCreacion + ", categoria=" + categoria + ", autor=" + autor + ", tags="
				+ tags + "]";
	}

	
	
	
	
	
	
}
