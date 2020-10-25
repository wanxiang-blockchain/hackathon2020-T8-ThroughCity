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
			title: "活动名称",
			dataIndex: "name",
			key: "name",
		},
		{
			title: "活动简介",
			dataIndex: "content",
			key: "content",
		},
		{
			title: "活动方公司",
			dataIndex: "companyName",
			key: "companyName",
		},
		{
			title: "活动开始日期",
			dataIndex: "startDate",
			key: "startDate",
		},
		{
			title: "活动结束日期",
			dataIndex: "endDate",
			key: "endDate",
		},
		{
			title: "活动地点",
			dataIndex: "address",
			key: "address",
		},
		{
			title: "积分",
			dataIndex: "amount",
			key: "amount",
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
			url: "http://172.25.2.220:8080/api/v1/city/activity/list",
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
				setLoading(true)
				console.log(values);
				axios({
					url: "http://172.25.2.220:8080/api/v1/city/activity/add",
					data: {
						amount: values.amount,
						name: values.name,
						content: values.content,
						companyName: values.companyName,
						address: values.address,
						startDate: values.rentDate[0].format("YYYY-MM-DD"),
						endDate: values.rentDate[1].format("YYYY-MM-DD"),
					},
				}).then((res) => {
					setLoading(false)
					if (res && res.returnCode % 1000 === 0) {
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
				新增
			</Button>
			<Table columns={columns} dataSource={dataSource} />
			<Modal
				onOk={handleOk}
				className="modal"
				onCancel={addCompany}
				visible={visible}
				title="新增活动"
				confirmLoading={confirmLoading}
			>
				<Form form={form}>
					<Form.Item
						label="活动名称"
						name="name"
						rules={[{ required: true, message: "请输入活动名称" }]}
					>
						<Input />
					</Form.Item>
					<Form.Item
						label="活动简介"
						name="content"
						rules={[{ required: true, message: "请输入活动简介" }]}
					>
						<Input.TextArea />
					</Form.Item>
					<Form.Item
						label="活动方公司"
						name="companyName"
						rules={[{ required: true, message: "请输入活动方公司" }]}
					>
						<Input />
					</Form.Item>
					<Form.Item
						label="活动起止日期"
						name="rentDate"
						rules={[{ required: true, message: "请选择活动起止日期" }]}
					>
						<DatePicker.RangePicker />
					</Form.Item>
					<Form.Item
						label="活动地点"
						name="address"
						rules={[{ required: true, message: "请输入活动地点" }]}
					>
						<Input />
					</Form.Item>
					<Form.Item
						label="活动积分"
						name="amount"
						rules={[{ required: true, message: "请输入活动积分" }]}
					>
						<Input />
					</Form.Item>
				</Form>
			</Modal>
		</div>
	);
}

export default Home;
