
import { PayloadAction, configureStore, createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { IPassagem } from "../../model/IPassagem";
import { IFiltroPassagem } from "../../model/IFiltroPassagem";

const initialState: { passagens: IPassagem[], filtradas: IPassagem[] } = { passagens: [], filtradas: [] };

const passagemSlice = createSlice({
    name: 'passagem',
    initialState,
    reducers: {
        limpar: (state) => {
            state.passagens = [];
        },
        definir: (state, action: PayloadAction<IPassagem[]>) => {
            state.passagens = action.payload;
        },
        adicionar: (state, action: PayloadAction<IPassagem>) => {
            state.passagens.push(action.payload);
        },
        filtrar: (state, action: PayloadAction<IFiltroPassagem>) => {

            const { origem, destino, dataPartidaMin, dataPartidaMax } = action.payload;

            const filtroPassagem = (p: IPassagem) =>
                (origem.length === 0 || p.origem === origem)
                && (destino.length === 0 || p.destino.nome === destino)
                && (dataPartidaMin.length === 0 || p.dataPartida >= dataPartidaMin)
                && (dataPartidaMax.length === 0 || p.dataPartida <= dataPartidaMax);

            const result = state.passagens.filter(filtroPassagem);
            state.filtradas = result;
        }
    },
    extraReducers: (builder) => {
        builder.addCase(buscarPassagens.fulfilled, (state, action: PayloadAction<IPassagem[]>) => {
            state.passagens = action.payload;
            state.filtradas = action.payload;
        });
    }
});

export const buscarPassagens = createAsyncThunk(
    'passagem/buscarPassagens',
    async () => {
        let p = new Promise((resolve, reject) => {
            fetch('http://localhost:5269/api/Passagem')
                .then(res => res.json())
                .then(resolve)
                .catch(reject)
        });
    
        try {
            let result = await p as IPassagem[];
            return result;
        }
        catch (e) {
            return [];
        }
    }
)

export default passagemSlice.reducer;

export const { limpar, definir, adicionar, filtrar } = passagemSlice.actions;
