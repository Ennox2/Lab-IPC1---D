const express = require('express'); 

const router = express.Router(); // Crea el Express router

//Importaciones de funciones creadas en controladores
const { Registro, GetUsers, Login } = require('../controladores/ingreso');
const { DeleteUser } = require('../controladores/delete');
const { UpdateUser } = require('../controladores/update');
const { GetPosts, Publicar, reporteCategoria } = require('../controladores/posts');


//Metodos Post
router.post('/Registro', Registro)
router.post('/Login', Login)

//Get
router.get('/users', GetUsers)

//Metodos delete
router.delete('/delete_user', DeleteUser)

//Metodos put
router.put('/update', UpdateUser )


router.post('/publicar', Publicar)
router.get('/posts', GetPosts)
router.get('/reportecategoria', reporteCategoria)



module.exports = router; //Exporta el router para usarla en app.js
