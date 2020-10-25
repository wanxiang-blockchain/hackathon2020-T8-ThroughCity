import { Button, message, Modal } from 'antd'
import React, { useState } from 'react'
import './index.less'

function Monitor() {
    const [money, setMoney] = useState(300)

    function getMoney() {
        Modal.confirm({
            title: '是否提现',
            onOk: () => {
                message.success('提现成功')
                setMoney(0)
            },
        })
    }

    return <div className="moinitor">
        <div className="top">
            <div className="box">
                <div className="box-title">剩余可提现金额</div>
                <div className="value">{money}</div>
            </div>
            <div className="box">
                <div className="box-title">托管账户总金额</div>
                <div className="value">1000</div>
            </div>
        </div>
        <div className="middle"> 
            <h1>发起提现</h1>
            <Button disabled={money<=0} type="primary" size="large" className="button" onClick={getMoney}>提现</Button>
        </div>
    </div>
}

export default Monitor;