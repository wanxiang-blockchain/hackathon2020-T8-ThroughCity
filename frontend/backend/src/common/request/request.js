import { message } from 'antd'
import axios from 'axios'

function ajax(params) {
    const obj = {
        url: params.url || '',
        method: params.method || 'post',
        data: params.data || {},
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
    }
    return axios.request(obj).then(response => {
        if (response && response.status === 200) {
            return response && response.data
        }
    })
    .catch(err => console.log(err))
}

export default ajax