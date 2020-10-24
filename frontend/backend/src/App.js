import React, { useEffect, useState } from "react";
import Layout from "./pages/layouts/index";
import Home from "./pages/home/index";
import { BrowserRouter, Route, Router, Switch, Redirect } from "react-router-dom";
import './index.css'

function App() {
	useEffect(() => {
		let child = document.getElementById("loading");
		child.parentNode.removeChild(child);
	}, []);

	return (
		<BrowserRouter>
			<Route path="/" component={Layout} />
			<Switch>
				<Route exact path="/" component={Home} />
				<Redirect to="/" />
			</Switch>
		</BrowserRouter>
	);
}
export default App;
