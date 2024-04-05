import React, { useState, useEffect } from 'react'; // Importa React, el hook useState y el hook useEffect 
import { Modal, Button } from 'react-bootstrap'; // Importa componentes de React Bootstrap

const Administrador = () => {
    const [users, setUsers] = useState([]); // Declara el estado 'users' para almacenar la lista de usuarios
    const [selectedUser, setSelectedUser] = useState(null); // Declara el estado 'selectedUser' para almacenar el usuario seleccionado
    const [validarEliminacion, setValidarEliminacion] = useState(false); // Declara el estado 'validarEliminacion' para controlar la eliminación de usuarios


    useEffect(() => { // Utiliza el hook useEffect para cargar la lista de usuarios cuando se monta el componente o cuando 'validarEliminacion' cambia
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:5000/users', {
                    method: 'GET',
                });
                if (response.ok) {
                    const data = await response.json();
                    setUsers(data.usuarios);
                }
            } catch (error) {
                console.error('Error al realizar la solicitud:', error);
            }
        };
    
        fetchData();
    }, [validarEliminacion]);


    const deleteUser = async (carnet) => { // Define una función para eliminar un usuario
        try {
            const response = await fetch('http://localhost:5000/delete_user', {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ carnet: carnet }),
            });

            const data = await response.json();
            console.log(data)

            if (! data.error) {
                alert(data.msj)
                setValidarEliminacion(!validarEliminacion);
            } else {
                alert(data.msj);                
            }
        } catch (error) {
            console.error('Error al realizar la solicitud:', error);
        }
        
    };

    const viewUser = (user) => { // Define una función para mostrar los detalles de un usuario
        setSelectedUser(user); // Actualiza el estado 'selectedUser' con el usuario seleccionado
    };

    const handleClose = () => { // Define una función para cerrar el modal
        setSelectedUser(null); // Actualiza el estado 'selectedUser' para que no haya ningún usuario seleccionado
    };



    return ( // Devuelve el contenido JSX que representa el componente
    <div className="table-container"> {/* Contenedor de la tabla */}
        <table className="table table-bordered text-center"> {/* Tabla con bordes y alineación centrada */}
            <thead className="table-dark"> {/* Cabecera de la tabla con fondo oscuro */}
                <tr> {/* Fila de la cabecera */}
                    <th>Carnet</th> {/* Celda de la cabecera */}
                    <th>Nombre</th> {/* Celda de la cabecera */}
                    <th>Edad</th> {/* Celda de la cabecera */}
                    <th>Facultad</th> {/* Celda de la cabecera */}
                    <th>Acciones</th> {/* Celda de la cabecera */}
                </tr>
            </thead>
            <tbody> {/* Cuerpo de la tabla */}
                {users.map(user => ( // Mapea cada usuario en la lista 'users' y renderiza una fila de la tabla para cada usuario
                    <tr key={user.carnet}> {/* Fila de la tabla con clave única basada en el carnet del usuario */}
                        <td>{user.carnet}</td> {/* Celda con el carnet del usuario */}
                        <td>{user.nombre}</td> {/* Celda con el nombre del usuario */}
                        <td>{user.edad}</td> {/* Celda con la edad del usuario */}
                        <td>{user.facultad}</td> {/* Celda con la facultad del usuario */}
                        <td> {/* Celda con botones de acciones */}
                            <button className="btn btn-danger" onClick={() => deleteUser(user.carnet)}>Eliminar</button> {/* Botón para eliminar el usuario */}
                            <button className="btn btn-primary" onClick={() => viewUser(user)}>Ver</button> {/* Botón para ver los detalles del usuario */}
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>

        {selectedUser && ( /* Renderiza un modal si hay un usuario seleccionado */
            <Modal show={true} onHide={handleClose}> {/* Modal que se muestra si 'selectedUser' es verdadero y se cierra al hacer clic fuera de él */}
                <Modal.Header closeButton> {/* Cabecera del modal con un botón para cerrar */}
                    <Modal.Title>Detalles del Usuario</Modal.Title> {/* Título del modal */}
                </Modal.Header>
                <Modal.Body> {/* Cuerpo del modal */}
                    <p><strong>Carnet:</strong> {selectedUser.carnet}</p> {/* Muestra el carnet del usuario */}
                    <p><strong>Nombre:</strong> {selectedUser.nombre}</p> {/* Muestra el nombre del usuario */}
                    <p><strong>Edad:</strong> {selectedUser.edad}</p> {/* Muestra la edad del usuario */}
                    <p><strong>Facultad:</strong> {selectedUser.facultad}</p> {/* Muestra la facultad del usuario */}
                </Modal.Body>
                <Modal.Footer> {/* Pie del modal */}
                    <Button variant="secondary" onClick={handleClose}> {/* Botón para cerrar el modal */}
                        Cerrar
                    </Button>
                </Modal.Footer>
            </Modal>
        )}
    </div>
);




}



export default Administrador;