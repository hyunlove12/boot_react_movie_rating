// node에서 경로를 조작할 수 있게 주는 모듈 -> 노드의 기본 모듈
const path = require('path');
const webpack = require('webpack');

// name : 웹팩이름
module.exports = {
    name : 'movie-rating',
    mode : 'development', // 실서비스 : production
    devtool : 'eval', // 빠르게 하겠다?? 무슨의미? eval -> 개발 , production -> hidden-source-map
    resolve : {
        extensions : ['.js', '.jsx']
    },
    // entry : 입력
    entry : {
        // client.jsx에서 WordRelay.jsx를 호출하기 때문에 './WordRelay.jsx'를 넣을 필요 없다
        // 확장자도 적을필요 없음 -> resolve의 extensions에 선언되 확장자를 자동으로 검색한다.
        // css, json등의 파일도 넣을 수 있다.
         app : ['./client/index'],
        // app : path.resolve(__dirname) + 'client'
      //  app : './src/client'
    },
    // webpack과 babel의 연결
    // entry의 파일을 읽어서 모듈을 적용한 후 output으로 출력
    // module이 loaders의미
    module : {
        rules : [{
            // 규칙을 적용할 파일들
            // js, jsx파일을 적용하겠따
            // babel-loader를 적용하겠다
            test : /\.jsx?$/,
            loader : 'babel-loader',
            // babel의 옵션
            options : {
                // plugin들의 모임이 presets
                presets : [
                    // preset-env에 대한 설정 시 배열로
                    ['@babel/preset-env', {
                        // 브라우저에 대한 설정
                        // 옛날 버전일 수록 지원이 어렵기 때문 설정해 주는것이 필요 -> 설정이 없으면 느려진다...
                        // https://github.com/browserslist/browserslist
                        targets : {
                            browsers :['> 5% in KR', 'last 2 chrome versions']
                        },
                        debug : true,
                    }],
                     '@babel/preset-react'],
                plugins : ['@babel/plugin-proposal-class-properties']
            }
        },
        {
        	test : /\.css$/,
        	loader : ['style-loader', 'css-loader']
        },
        {
        	test : /\.(png|jpg)$/,
        	loader : ['file-loader']
        }
        ]
    },
    // plugin : 확장 프로그램
    plugins : [
        // loader에 dubug릃 해주는 것것        new webpack.LoaderOptionsPlugin({ debug:true })
    ],
    // output : 출력
    output : {
        // __dirname -> 현재 폴더
        // 경로시작이 윈도우? 프로젝트단위가 아닌? 헷갈림...
        path : path.join(__dirname, 'src/main/resources/static/dist'),
        filename : 'app.js'
    }

};