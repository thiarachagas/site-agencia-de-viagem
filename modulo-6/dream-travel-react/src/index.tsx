import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { Provider } from 'react-redux';
import { store } from './state/store';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import { DestinoPage } from './page/DestinoPage';
import { HomePage } from './page/HomePage';
import { DetalhePassagemPage } from './page/DetalhePassagemPage';
import { SobreNosPage } from './page/SobreNosPage';
import { CentralAjudaPage } from './page/CentralAjudaPage';
import { DuvidasPage } from './page/DuvidasPage';

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    children: [
      {
        path: '',
        element: <HomePage />
      },
      {
        path: '/destino',
        element: <DestinoPage />
      },
      {
        path: '/passagem/:id',
        element: <DetalhePassagemPage />
      },
      {
        path: '/sobre-nos',
        element: <SobreNosPage />
      },
      {
        path: '/central-de-ajuda',
        element: <CentralAjudaPage />
      },
      {
        path: '/duvidas',
        element: <DuvidasPage />,
      },
    ]
  },
])

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <Provider store={store}>
    <React.StrictMode>
      <RouterProvider router={router}/>
    </React.StrictMode>
  </Provider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
