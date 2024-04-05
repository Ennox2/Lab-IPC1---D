import './App.css';
import Login from './componentes/login';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Registro from './componentes/registro';
import Administrador from './componentes/admin';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/registro" element={<Registro />} />
        <Route path="/admin" element={<Administrador />} />
      </Routes>
    </Router>
  );
}

export default App;
