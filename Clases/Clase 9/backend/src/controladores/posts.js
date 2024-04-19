const { list_users, list_posts } = require("../datalist/list");
const Post = require("../objetos/post");

function Publicar(req, res){
    try{

        const {carnet, category, text, image, anonymus} = req.body; 

        const usuario = list_users.find(find_user => find_user.carnet == carnet)
        const currentDate = new Date();

        if (usuario){
            let carnetToUse = carnet;
            if(anonymus){
                carnetToUse = null;
            }
            const newPost = new Post(carnetToUse, category, text, image, currentDate, 0)
            list_posts.push(newPost);
            res.json({mensaje : "Publicacion hecha."})
        }
        else{

            res.json({mensaje : "Error, no se encuentra el usuario"})
        }
        
    } catch (error){
        //Si ocurre un error, imprime en consola y envia mensaje
        console.log(error)
        res.json({mensaje : "Ocurrio un error"})
    }
}

function buscarNombreFacultad(carnet) {

    if (carnet === null){
        return { nombre: 'Anonimo', facultad: 'Anonimo' };
    }

    const usuarioEncontrado = list_users.find(usuario => usuario.carnet === carnet);
    if (usuarioEncontrado) {
      return { nombre: usuarioEncontrado.nombre, facultad: usuarioEncontrado.facultad };
    } 
}
  

function GetPosts(req, res) {
    try{        
        const list_posts_con_nombres_facultades = list_posts.map(post => {
            const { nombre, facultad } = buscarNombreFacultad(post.carnet);
            return { ...post, name: nombre, faculty: facultad };
        });

        res.json({mensaje : "Exito", posts: list_posts_con_nombres_facultades})
    }catch (error) {        
        console.log(error)
        res.json({mensaje : "Ocurrio un error"})
    }

}


function reporteCategoria(req, res) {
    try{        
        const categories = ['Anuncio Importante', 'Divertido', 'Académico', 'Variedad'];
        const countByCategory = {};

        // Inicializar el conteo de todas las categorías a 0
        categories.forEach(category => {
            countByCategory[category] = 0;
        });

        // Contar la cantidad de posts por categoría
        for (const post of list_posts) {
            countByCategory[post.category]++;
        }

        res.json({countByCategory})
    }catch (error) {        
        console.log(error)
        res.json({mensaje : "Ocurrio un error"})
    }

}

module.exports = {
    Publicar,
    GetPosts,
    reporteCategoria
}