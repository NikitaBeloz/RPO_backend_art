import { combineReducers, createStore, applyMiddleware } from 'redux';
import { createLogger } from 'redux-logger';
import Utils from './Utils';

/* ACTIONS */

const alertConstants = {
    ERROR: 'ERROR',
    CLEAR: 'CLEAR',
};

const userConstants = {
    LOGIN: 'USER_LOGIN',
    LOGOUT: 'USER_LOGOUT',
};


/* ACTION GENERATORS */

export const alertActions = {
    error,
    clear
};

function error(msg) {
    return { type: alertConstants.ERROR, msg }
}

function clear() {
    return { type: alertConstants.CLEAR }
}

export const userActions = {
    login,
    logout
};

function login(user) {
    Utils.saveUser(user)
    return { type: userConstants.LOGIN, user }
}

function logout() {
    Utils.removeUser()
    return { type: userConstants.LOGOUT }
}

/* REDUСERS */

let user =  Utils.getUser()
const initialState = user ? { user } : {}

function authentication(state = initialState, action) {
    console.log("authentication")
    switch (action.type) {
        case userConstants.LOGIN:
            return { user: action.user };
        case userConstants.LOGOUT:
            return { };
        default:
            return state
    }
}

function alert(state = {}, action) {
    console.log("alert")
    switch (action.type) {
        case alertConstants.ERROR:
            return { msg: action.msg };
        case alertConstants.CLEAR:
            return { };
        default:
            return state
    }
}

/* STORE */

const rootReducer = combineReducers({
    authentication, alert
});

const loggerMiddleware = createLogger();

export const store = createStore(
    rootReducer,
    applyMiddleware( loggerMiddleware )
);