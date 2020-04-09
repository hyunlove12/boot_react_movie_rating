import React, { Suspense, useState } from 'react';
import { Route, Switch } from "react-router-dom";

// pages for this product
import Footer from "./include/Footer.jsx"
import Menu from "./include/Menu.jsx"
import LoginPage from "./login/LoginPage.jsx"
import RatingMain from "./movie/RatingMain.jsx"
import { withCookies, Cookies, ReactCookieProps } from 'react-cookie';




function App(props) {
  const [cookies, setCookies] = useState(props.cookies);
  
  return (
    <Suspense fallback={(<div>Loading...</div>)}>   
        <Switch>          
          {/* path -> 컴포넌트 경로(url) */}
          <Route exact path="/login" component={LoginPage} />
          <Route exact path="/ratingmain" component={RatingMain} />          
        </Switch>
        <Footer />
    </Suspense>
  );
}

export default withCookies(App)

