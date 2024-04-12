import React, { useState, useEffect } from 'react';
import Sidebar from './navbar';


function PostList() {
  // Estado para almacenar los posts
  const [posts, setPosts] = useState([]);
  // Estado para controlar la visibilidad de los comentarios de cada post
  const [showComments, setShowComments] = useState([]);

  // Simulación de datos de ejemplo
  const exampleData = [
    {
      id: 1,
      name: 'Juan Pérez',
      faculty: 'Ingeniería Informática (Facultad de Ingeniería)',
      category: 'Anuncio Importante',
      text: '¡Hola mundo!',
      image: 'https://via.placeholder.com/150',
      dateTime: '2024-04-10T12:00:00',
      likes: 10,
      comments: [
        { id: 1, name: 'Ana García', faculty: 'Facultad de Ingeniería', comment: '¡Genial!' },
        { id: 2, name: 'Pedro Martínez', faculty: 'Facultad de Ingeniería', comment: 'Interesante.' }
      ]
    },
    {
      id: 2,
      name: 'María García',
      faculty: 'Administración de Empresas (Facultad de Economía)',
      category: 'Divertido',
      text: '¡Feliz viernes!',
      dateTime: '2024-04-09T15:30:00',
      likes: 15,
      comments: [
        { id: 3, name: 'Sofía Rodríguez', faculty: 'Facultad de Economía', comment: '¡Jajaja!' },
        { id: 4, name: 'Eduardo Gómez', faculty: 'Facultad de Economía', comment: 'XD.' }
      ]
    }
  ];

  // Simulación de obtención de datos de posts
  useEffect(() => {

    const fetchData = async () => {
      try {
          const response = await fetch('http://localhost:5000/posts', {
              method: 'GET',
          });
          if (response.ok) {
              const data = await response.json();
              setPosts(data.posts);
          }
          } catch (error) {
              console.error('Error al realizar la solicitud:', error);
          }
      };

    fetchData();
    
    //setPosts(exampleData);
    // Inicializar el estado para controlar la visibilidad de los comentarios de cada post
    //setShowComments(Array(exampleData.length).fill(false));
  }, []);

  // Función para cambiar la visibilidad de los comentarios de un post
  const toggleComments = (index) => {
    const newShowComments = [...showComments];
    newShowComments[index] = !newShowComments[index];
    setShowComments(newShowComments);
  };

  return (
    <div className="App">
      <Sidebar activeWindow="posts" />

      <div className="content" style={{ overflowY: 'auto', maxHeight: '100vh' }}>
        <div className="container mt-5">
          <h2 style={{ color: 'white'}}>Lista de Posts</h2>
          {posts.map((post, index) => (
            <div key={post.id} className="card mb-3">
              <div className="card-body">
                <h5 className="card-title">{post.name}</h5>
                <p className="card-text">{post.faculty}</p>
                <span className="badge bg-primary">{post.category}</span>
                <p className="card-text mt-2">{post.text}</p>
                {post.image && <img src={post.image} className="img-fluid mb-2" alt="Imagen del post" />}
                <p className="card-text"><small className="text-muted">Publicado el {new Date(post.dateTime).toLocaleString()}</small></p>
                <div className="d-flex justify-content-between">
                  <p className="card-text"><small className="text-muted">{post.likes} Likes</small></p>
                  <button onClick={() => toggleComments(index)} className="btn btn-secondary">Mostrar Comentarios</button>
                </div>
                {showComments[index] && (
                  <div className="comments mt-3">
                    <h6>Comentarios:</h6>
                    {post.comments.map((comment) => (
                      <div key={comment.id} className="card mb-2">
                        <div className="card-body">
                          <p><strong>{comment.name}</strong> ({comment.faculty})</p>
                          <p>{comment.comment}</p>
                        </div>
                      </div>
                    ))}
                  </div>
                )}
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default PostList;
