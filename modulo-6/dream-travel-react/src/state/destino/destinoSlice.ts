import { PayloadAction, createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { IDestino } from "../../model/IDestino";

const initialState: { destinos: IDestino[] } = { destinos: [] };

const destinoSlice = createSlice({
    name: 'destino',
    initialState,
    reducers: {
        limpar: (state) => {
            state.destinos = [];
        },
        definir: (state, action: PayloadAction<IDestino[]>) => {
            state.destinos = action.payload;
        },
        adicionar: (state, action: PayloadAction<IDestino>) => {
            state.destinos.push(action.payload);
        }
    },
    extraReducers: (builder) => {
        builder.addCase(buscarDestinos.fulfilled, (state, action: PayloadAction<IDestino[]>) => {
            state.destinos = action.payload;
        });
    }
});

export const buscarDestinos = createAsyncThunk(
    'destino/buscarDestinos',
    async () => {
        let p = new Promise((resolve, reject) => {
            fetch('http://localhost:5269/api/Destino')
                .then(res => res.json())
                .then(resolve)
                .catch(reject);
        });

        return await p as IDestino[];
    }
);

export default destinoSlice.reducer;

export const { limpar, definir, adicionar } = destinoSlice.actions;