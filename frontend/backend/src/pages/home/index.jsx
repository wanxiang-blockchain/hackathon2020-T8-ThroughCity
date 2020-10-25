import React, { useState, useEffect } from "react";
import { Input, Modal, Table, Form, Button, DatePicker } from "antd";
import axios from "../../common/request/request";
import "./index.less";

function Home() {
	const [visible, setVisible] = useState(false);
	const [dataSource, setdataSource] = useState([]);
	const [form] = Form.useForm();
	const [confirmLoading, setLoading] = useState(false)
	const columns = [
		{
			title: "公司名称",
			dataIndex: "name",
			key: "name",
		},
		{
			title: "token余额",
			dataIndex: "amount",
			key: "amount",
		},
		{
			title: "起租日期",
			dataIndex: "rentStart",
			key: "rentStart",
		},
		{
			title: "合同期限",
			dataIndex: "rentYears",
			key: "rentYears",
		},
		{
			title: "操作",
			dataIndex: "operation",
			key: "operation",
			render: () => {
				return (
					<React.Fragment>
						<a style={{marginRight: '20px'}}>修改</a>
						<a>删除</a>
					</React.Fragment>
				);
			},
		},
	];
	useEffect(() => {
		getList();
	}, []);
	function getList() {
		axios({
			url: "http://172.25.2.220:8080/api/v1/city/company/list",
			method: "post",
			data: {},
		}).then((res) => {
			console.log(res);
			if (res && res.returnCode % 1000 === 0 && res.data && res.data.length) {
				res.data.forEach((i) => (i.key = i.id));
				setdataSource(res.data || []);
			}
		});
	}
	function addCompany() {
		setVisible(!visible);
	}
	function handleOk() {
		form.validateFields()
			.then((values) => {
				console.log(values);
				axios({
					url: "http://172.25.2.220:8080/api/v1/city/company/add",
					data: {
						amount: values.amount,
						name: values.name,
						rentYear: values.rentYear,
						rentStart: values.rentStart.format("YYYY-MM-DD"),
					},
				}).then((res) => {
					setLoading(false)
					if (res.returnCode % 1000 === 0) {
						setVisible(!visible);
						getList();
					}
				});
			})
			.catch((err) => {
				setLoading(false)
				console.log(err);
			});
	}
	return (
		<div className="home">
			<Button className="button" type="primary" onClick={addCompany}>
				新建
			</Button>
			<Table columns={columns} dataSource={dataSource} />
			<Modal
				onOk={handleOk}
				className="modal"
				onCancel={addCompany}
				visible={visible}
				title="新建入驻企业"
				confirmLoading={confirmLoading}
			>
				<Form form={form}>
					<Form.Item
						label="公司名称"
						name="name"
						rules={[{ required: true, message: "请输入公司名称" }]}
					>
						<Input />
					</Form.Item>
					<Form.Item
						label="token余额"
						name="amount"
						rules={[{ required: true, message: "请输入token余额" }]}
					>
						<Input />
					</Form.Item>
					<Form.Item
						label="起租日期"
						name="rentStart"
						rules={[{ required: true, message: "请选择起租日期" }]}
					>
						<DatePicker />
					</Form.Item>
					<Form.Item
						label="合同期限"
						name="rentYear"
						rules={[{ required: true, message: "请输入合同期限" }]}
					>
						<Input />
					</Form.Item>
				</Form>
			</Modal>
		</div>
	);
}

export default Home;
