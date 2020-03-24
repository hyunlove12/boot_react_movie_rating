import React, { Suspense } from 'react';
import { Route, Switch } from "react-router-dom";

// pages for this product
import Footer from "./include/Footer.jsx"
import Menu from "./include/Menu.jsx"
import LoginPage from "./login/LoginPage.jsx"
import RatingMain from "./movie/RatingMain.jsx"

function App() {
  return (
    <Suspense fallback={(<div>Loading...</div>)}>   
        <Switch>
          {/* null -> 아무나 접근, false -> 로그인한 사람은 접속 못한다 true -> 로그인 한 사람만 접근 가능 */}
          {/* path -> 컴포넌트 경로(url) */}
          <Route exact path="/log" component={LoginPage} />
          <Route exact path="/ratingmain" component={RatingMain} />          
        </Switch>
        <Footer />
    </Suspense>
  );
}

export default App

