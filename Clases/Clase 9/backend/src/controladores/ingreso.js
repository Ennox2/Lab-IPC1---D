//Importacion de la lista de usuarios y el Objeto Usuario
const { list_users } = require("../datalist/list");
const Usuario = require("../objetos/Usuario");


function Registro(req, res){
    try{

        // Crear una nueva instancia de Usuario con los datos proporcionados en el cuerpo de la solicitud
        const data = req.body; 
        const newUser = new Usuario(data.carnet, data.nombre, data.edad, data.facultad, data.password); 

        // Agregar el nuevo usuario a la lista
        list_users.push(newUser);

        // Enviar una respuesta con el mensaje de confirmación
        res.json({mensaje : "Usuario registrado correctamente."})
        
    } catch (error){
        //Si ocurre un error, imprime en consola y envia mensaje
        console.log(error)
        res.json({mensaje : "Ocurrio un error al hacer el registro"})


    }
}


function Login(req, res){
    try{

        //Parametros recibidos desde el JSON
        const {carnet, password} = req.body; 

        // Buscar el usuario en la lista por su carnet
        const usuario = list_users.find(find_user => find_user.carnet == carnet && find_user.password == password)
        
        if (usuario){
            // Enviar una respuesta con los datos del usuario sin la contraseña
            res.json({mensaje : "Usuario ha iniciado sesion", 
            user: {
                carnet: usuario.carnet,
                nombre: usuario.nombre,
                edad: usuario.edad,
                facultad: usuario.facultad
            },           
            error: false})
        }else {
            // Si el usuario no existe o la contraseña es incorrecta, devolver un mensaje de error
            res.json({mensaje : "Usuario no esta en el sistema", error: true})
        }
        
    } catch (error){
        //Si ocurre un error, imprime en consola y envia mensaje
        console.log(error)
        res.json({mensaje : "Ocurrio un error al hacer el registro"})
    }
}



function GetUsers(req, res) {
    try{
        //Devolver la lista de usuarios junto con un mensaje de Exito al hacer la peticion
        res.json({mensaje : "Exito", usuarios: list_users})
    }catch (error) {
        //Si ocurre un error, imprime en consola y envia mensaje
        console.log(error)
        res.json({mensaje : "Ocurrio un error al hacer el registro"})
    }

}

//Exportacion para poder ser importado en routes.js
module.exports = {
    Registro,
    GetUsers,
    Login
}