import React, { useState, useEffect } from 'react';
import { Menu, Dropdown, Spin } from 'antd';
import {
  SettingOutlined,
  MenuUnfoldOutlined,
  MenuFoldOutlined,
  DownOutlined,
} from '@ant-design/icons';
import '../../assets/style/common.less';
import './index.less';

const { Item } = Menu;

function Layout({ children, location, route, history, match, loading }) {
  const [show, setShow] = useState(true);
  const arr = [
    // { key: 'user', name: '直播互动' },
    { key: 'guest', name: '嘉宾信息管理' },
    { key: 'sponsor', name: '赞助商管理' },
    // { key: 'video', name: '直播回放管理' },
    { key: 'statics', name: '数据统计' },
  ];
  const [selectedKeys, setSelectedKeys] = useState([arr[0].key]);

  useEffect(() => {
    let item = arr.find(i => `/${i.key}` === location.pathname);
    if (item) setSelectedKeys([item.key]);
  }, []);

  function goPage(item) {
    console.log(item, location);
    if (location.pathname == `/${item['key']}`) return;
    history.push(`/${item['key']}`);
    setSelectedKeys([item['key']]);
  }

  const goOut = () => {
    sessionStorage.clear();
    history.push('/login');
  };

  const menu = (
    <Menu>
      <Menu.Item>
        <a className="right-item" target="_blank" onClick={goOut}>
          登出
        </a>
      </Menu.Item>
    </Menu>
  );

  return (
    <Spin wrapperClassName="loading" spinning={loading > 0} size="large">
      <div className="container">
        <div className="left" style={{ width: show ? '240px' : 0 }}>
          <div className="topBox">
            后台
          </div>
          <Menu
            mode="inline"
            theme="dark"
            onClick={goPage}
            selectedKeys={selectedKeys}
          >
            {arr.map(item => (
              <Item icon={<SettingOutlined />} key={item.key}>
                {item.name}
              </Item>
            ))}
          </Menu>
        </div>
        <div className="right">
          <div className="topBox">
            {show ? (
              <MenuFoldOutlined
                className="icon"
                onClick={() => setShow(false)}
              />
            ) : (
              <MenuUnfoldOutlined
                className="icon"
                onClick={() => setShow(true)}
              />
            )}
            <Dropdown overlay={menu}>
              <a className="out" onClick={e => e.preventDefault()}>
                <DownOutlined />
              </a>
            </Dropdown>
          </div>
          <div className="content">{children}</div>
        </div>
      </div>
    </Spin>
  );
}

export default Layout;
