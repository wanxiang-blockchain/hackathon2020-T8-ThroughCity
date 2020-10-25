import React, { useEffect, useState } from "react";
import Layout from "./pages/layouts/index.jsx";
import { BrowserRouter, Route, Router, Switch, Redirect } from "react-router-dom";
import './index.css'

function App() {
	useEffect(() => {
		let child = document.getElementById("loading");
		child.parentNode.removeChild(child);
	}, []);

	return (
		<BrowserRouter>
      <Route path="/biz" component={Layout} />
		</BrowserRouter>
	);
}
export default App;
