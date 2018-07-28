class CrearPost{
   constructor(){
    this.quill;
   }


   mostrarCrearPost(){
    const  template = `
      <section class="main-crear-post">
      <h2 class="titulo-main">Crear Post</h2>
      <form>
      <input type="text" id="crear-titulo" name="crear-titulo" placeholder="Titulo">
      <input type="text" id="crear-subtitulo" name="crear-subtitulo" placeholder="Subtitulo">
      <select id="seleccionarCat-crearPost">
             <option selected disabled>Selecionar Categoria</option>
          ${categorias.map(categoria =>
            `<option value="${categoria.id}">${categoria.nombre}</option>`
          ).join('')}
        </select>
        </select>
    <label for="cuerpo"><h3>Cuerpo:</h3></label>
    <input name="cuerpo" id="crear-cuerpo" type="hidden">
    <div id="editor"></div>
      <h3>Tags:</h3>
      <textarea id="-crear-tag" name="tag" rows="5"></textarea>
      <button id="btn-publicar-post">Publicar</button>
      </form>
      </section>`;
      document.querySelector('#panel-main').innerHTML = template;
      let selectCategoria = document.querySelector('#seleccionarCat-crearPost');
      selectCategoria.addEventListener('change', (e)=>{
      	this.catSelect = e.target.value;
      });
      this.renderEditor();
  }

    renderEditor(){
        const toolbarOptions = [
            ['bold', 'italic', 'underline'],        
            ['blockquote', 'code-block','link', 'image', 'video'],
          
            [{ 'header': 1 }, { 'header': 2 }],               
            [{ 'list': 'ordered'}, { 'list': 'bullet' }],
            [{ 'script': 'sub'}, { 'script': 'super' }],      
            [{ 'indent': '-1'}, { 'indent': '+1' }],        
            [{ 'direction': 'rtl' }],                    
          
            [{ 'size': ['small', false, 'large', 'huge'] }],  
            [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
          
            [{ 'color': [] }, { 'background': [] }],        
            [{ 'font': [] }],
            [{ 'align': [] }]
          
            //['clean']                                       
          ];

         this.quill = new Quill('#editor', {
            modules: {  
              toolbar: toolbarOptions,
              imageResize: {}
            },
            placeholder: 'Construye aquí tu epopeya...',
            theme: 'snow'
          });
          const botonPublicarPost = document.querySelector('#btn-publicar-post');
          botonPublicarPost.addEventListener('click', (e)=>{
            this.publicarPost();
      });
    }

    publicarPost(){
    	console.log('Publicar')
    	let posteo = {};
    	let titulo = document.querySelector('#crear-titulo');
        let subTitulo = document.querySelector('#crear-subtitulo');
        let cuerpo = this.quill.getContents();
        let cat = {
        		"id" : this.catSelect
        };
        let autor = {
        		"id": 1
        };
        posteo.titulo=titulo.value;
        posteo.subTitulo=subTitulo.value;
        posteo.cuerpo = JSON.stringify(cuerpo);
        posteo.categoria = cat;
        posteo.autor = autor;
        const URL_PUBLICAR_POST = '/api/postServer/crearPost';
        let p = new Post();
        p.insertar(URL_PUBLICAR_POST, posteo);
    }
 
}

