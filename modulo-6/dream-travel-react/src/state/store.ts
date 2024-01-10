import { configureStore } from '@reduxjs/toolkit';
import destinoReducer from './destino/destinoSlice';
import passagemReducer from './passagem/passagemSlice';

export const store = configureStore({
    reducer: {
        destino: destinoReducer,
        passagem: passagemReducer,
    }
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
