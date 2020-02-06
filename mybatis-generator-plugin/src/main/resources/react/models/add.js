import formModel from '../constructor/form'

export default formModel({
    namespace: 'tbbrandAdd',
    state:{
        collapse:[
            {key:'base',label:'基本信息',defaultActive:true},
        ]
    },
    effects: {
        *getInfo({payload}, {call, put, select}){
            yield ;
        },
    },
    reducers: {

    }
})
