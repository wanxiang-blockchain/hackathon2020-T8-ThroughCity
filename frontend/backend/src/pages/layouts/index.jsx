import React, { useState, useEffect } from "react";
import { Menu, Dropdown, Spin } from "antd";
import {
	SettingOutlined,
	MenuUnfoldOutlined,
	MenuFoldOutlined,
	DownOutlined,
} from "@ant-design/icons";
import "../../assets/style/common.less";
import Home from '../home/index.jsx'
import Withdraw from '../withdraw/index.jsx'
import Active from '../active/index.jsx'
import { BrowserRouter, Route, Router, Switch, Redirect } from "react-router-dom";
import "./index.less";

const { Item } = Menu;

function Layout({ children, location, route, history, match, loading }) {
	const [show, setShow] = useState(true);
	const arr = [{ key: "home", name: "入驻企业管理" },{ key: "withdraw", name: "提现" },{ key: "active", name: "活动管理" }];
	const [selectedKeys, setSelectedKeys] = useState([arr[0].key]);

	useEffect(() => {
		let item = arr.find((i) => `/${i.key}` === location.pathname);
		if (item) setSelectedKeys([item.key]);
	}, []);

	function goPage(item) {
		console.log(item, location);
		if (location.pathname == `/${item["key"]}`) return;
		history.push(`/biz/${item["key"]}`);
		setSelectedKeys([item["key"]]);
	}

	const goOut = () => {
		sessionStorage.clear();
		history.push("/login");
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
				<div className="left" style={{ width: show ? "240px" : 0 }}>
					<div className="topBox">虹口科技产业园后台</div>
					<Menu mode="inline" theme="dark" onClick={goPage} selectedKeys={selectedKeys}>
						{arr.map((item, index) => (
							<Item icon={<SettingOutlined />} key={item.key}>
								{item.name}
							</Item>
						))}
					</Menu>
				</div>
				<div className="right">
					<div className="topBox">
						{show ? (
							<MenuFoldOutlined className="icon" onClick={() => setShow(false)} />
						) : (
							<MenuUnfoldOutlined className="icon" onClick={() => setShow(true)} />
						)}
						<Dropdown overlay={menu}>
							<a className="out" onClick={(e) => e.preventDefault()}>
								<DownOutlined />
							</a>
						</Dropdown>
					</div>
					<div className="content">
						{
							<Switch>
								<Route exact path="/biz/home" component={Home} />
								<Route exact path="/biz/withdraw" component={Withdraw} />
								<Route exact path="/biz/active" component={Active} />
							</Switch>
						}
					</div>
				</div>
			</div>
		</Spin>
	);
}

export default Layout;
