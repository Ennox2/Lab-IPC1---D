import './App.css';
import Login from './componentes/login';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Registro from './componentes/registro';
import Administrador from './componentes/admin';
import CreatePosts from './componentes/createpost';
import PostList from './componentes/posts';
import Reportes from './componentes/reportes';

function App() {
  return (
    <Router>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/registro" element={<Registro />} />
          <Route path="/admin" element={<Administrador />} />
          <Route path="/create" element={<CreatePosts />} />
          <Route path="/list" element={<PostList />} />
          <Route path="/reporte" element={<Reportes />} />
        </Routes>
    </Router>
  );
}

export default App;
