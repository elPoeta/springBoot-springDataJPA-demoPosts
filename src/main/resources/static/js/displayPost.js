class DisplayPost{
	
	 mostrarTodos(posts){
	        console.log(posts);
	        let template = posts.length != 0 ?  
	        `<section class="main-post">
	        <h2 class="titulo-main">Posts</h2>
	        ${posts.map(post =>
	            `<article class="article-post">
	                  <h2 class="titulo-post" id="post-${post.id}"><a href="#">${post.titulo}</a></h2>
	                  <p>${post.subTitulo}</p>
	               <ul>
	                  <li><a href="#">Categoria: ${post.categoria.nombre}</a></li>
	                  <li><a href="#">Autor: ${post.autor.nombre}</a></li>
	                  <li>Creado el ${post.fechaCreacion}</li>
	              </ul> 
	          </article>`).join('')}
	          </section>`
	        		 : `<section class="main-post">
	        		        <h2 class="titulo-main">Posts</h2>
	        		          <article class="article-post">
	        		                  <h2 class="titulo-post"><a href="#">Oops!! No hay posts disponibles</a></h2>
	        		                  <p>Se el primero en postear</p>
	        		          </article>
	        		          </section>`;		
	          
	        
	          document.querySelector('#panel-main').innerHTML = template;
	        
	          
	            let tituloPost = document.querySelectorAll('.titulo-post');
	            for (let i = 0; i < tituloPost.length; i++) {

	              tituloPost[i].addEventListener('click', ()=> {
	                let id = tituloPost[i].getAttribute('id');
	                id =id.replace(/\D/g,'');
	                this.mostrarBlogPost(id);
	              });
	          
	            }
	          
	        }

	    mostrarBlogPost(id){
	    	let traerPost = new Post();
	    	traerPost.get(`/api/postServer/post/${id}`)
	    	.then(data => {
	    		let cuerpo = JSON.parse(data.cuerpo);
	    	    this.renderBlog(data);
	    	});
	    }
	    
	    renderBlog(datos){
	        let options = {
	            readOnly: true,
	            scrollingContainer: '#scrolling-container'
	          };
	          let template = 
	          `<section class="blog-post">
	          <h2 class="titulo-main">${datos.titulo}</h2>
	          <p class="subtitulo-blogPost">${datos.subTitulo}</p>
	          <hr>
	          <div id="scrolling-container">
	          <div id="blog"></div>
	          </div>
	          </section>`;  
	          document.querySelector('#panel-main').innerHTML = template;
	          let blog = new Quill('#blog', options);
	          blog.setContents(JSON.parse(datos.cuerpo));
	    }
	    
}	    
	    
