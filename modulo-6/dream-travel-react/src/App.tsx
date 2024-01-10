import React from 'react';
import logo from './logo.svg';
import './App.css';
import { DestinoPage } from './page/DestinoPage';
import { Link, Outlet } from 'react-router-dom';
import { Header } from './component/Header';
import { Footer } from './component/Footer';

function App() {
  return (
    <div>
      <div className="container-fluid">
        <Header />
        <Outlet />
      </div>
      <Footer />
    </div>
  );
}

export default App;
