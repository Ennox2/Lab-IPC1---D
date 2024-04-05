import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';


const Registro = () => {

    const [carnet, setCarnet] = useState(''); 
    const [password, setPass] = useState(''); 
    const [nombre, setNombre] = useState('');
    const [edad, setEdad] = useState('');
    const [facultad, setFacultad] = useState('');

    const navigate = useNavigate();




    const handleSubmit = async (event) => {
        event.preventDefault(); 

        try{
            const response = await fetch('http://localhost:5000/Registro', {
                method: "POST",
                headers: {
                    'Content-Type' : 'application/json',
                },
                body: JSON.stringify({ carnet, password, nombre, facultad, edad }),
            })

            const data = await response.json(); 

            console.log(data)
            alert(data.mensaje)

        }catch (error){

            console.log("Error en la solicitud", error);

        }

    };




    return (

        <div className='d-flex align-items-center justify-content-center' style={{ minHeight: '100vh' }}>
            <div className="form-signin bg-body-tertiary " style={{ width: '100%', maxWidth: '400px', borderRadius: "20px" }}>

            <form onSubmit={handleSubmit}>
                <img classNameName="mb-4" src="https://previews.123rf.com/images/giamportone/giamportone2103/giamportone210300896/166486349-icono-de-inicio-de-sesi%C3%B3n-s%C3%ADmbolo-de-usuario-vectorial-pictograma-lineal-simple-iniciar-sesi%C3%B3n-en.jpg" alt="" width="72" height="72" />
                <h1 className="h3 mb-3 fw-normal">Registro</h1>

                <div className="form-floating">
                    <input required type="text" className="form-control" id="floatingInput" placeholder="name@example.com" value={carnet} onChange={(e) => setCarnet(e.target.value) } />
                    <label for="floatingInput">Carnet</label>
                </div>
                <div className="form-floating">
                    <input required type="password" className="form-control" id="floatingPassword" placeholder="Password" value={password} onChange={(e) => setPass(e.target.value) }/>
                    <label for="floatingPassword">Contraseña</label>
                </div>


                <div className="form-floating">
                    <input required type="text" className="form-control" id="floatingNombre" placeholder="Nombre" value={nombre} onChange={(e) => setNombre(e.target.value)}  />
                    <label htmlFor="floatingNombre">Nombre</label>
                </div>


                <div className="form-floating">
                    <input required type="number" className="form-control" id="floatingEdad" placeholder="Edad" value={edad} onChange={(e) => setEdad(e.target.value)}  />
                    <label htmlFor="floatingEdad">Edad</label>
                </div>



                <div className="form-floating">
                    <select required className="form-select" id="floatingFacultad" value={facultad} onChange={(e) => setFacultad(e.target.value)}>
                        <option value="">Selecciona una facultad</option>
                        <option value="Facultad 1">Facultad 1</option>
                        <option value="Facultad 2">Facultad 2</option>
                        <option value="Facultad 3">Facultad 3</option>
                    </select>
                    <label htmlFor="floatingFacultad">Facultad</label>
                </div>



                <button className="btn btn-primary w-100 py-2" type="submit">Registrarse</button>                
            </form>


            <p className="mt-3 mb-0 text-center">
                    ¿Ya tienes una cuenta? <button className="btn btn-secondary  btn-sm" onClick={() => navigate('/')}>Inicia sesion aquí</button>.
                </p>



            </div>
        </div>


    );

};

export default Registro; 