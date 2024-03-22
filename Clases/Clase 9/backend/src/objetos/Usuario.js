//cracion del objeto Usuario

class Usuario {

    constructor(carnet, nombre, edad, facultad, password){
        this.carnet = carnet; 
        this.nombre = nombre 
        this.edad = edad
        this.facultad = facultad
        this.password = password
    }

    
}

//Exportacion para poder ser importado en ingreso.js
module.exports = Usuario; 