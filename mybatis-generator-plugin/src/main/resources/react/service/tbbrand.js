import Utils from "../utils";

const { request, config } = Utils;
const { apiPrefix } = config;
const { basePrefix } = `${apiPrefix}/tbbrand`;

// 获取分页列表
export async function getPage (params) {
    return request({
        url: `${basePrefix}/getPage`,
        method: 'post',
        data: params,
    })
}

//获取一条数据
export async function getInfo({primaryKey}){
    return request({
        url: `${basePrefix}/${primaryKey}`,
        method: 'get'
    })
}