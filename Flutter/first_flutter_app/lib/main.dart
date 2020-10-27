import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  //This is the root widget of your application
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'First Flutter app',

      //Give it a nice teal theme
      theme: ThemeData(
        primarySwatch:Colors.teal,
      ),

      //This is for the home page
      home: myHome(title:'Home Page'),
    );
  }
}

//Declare myHome class
class myHome extends StatelessWidget{
  myHome({Key key, this.title}): super(key: key);
  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(

      //Main screen background color
      backgroundColor: Colors.white24,

      appBar: AppBar(
        title: Text(this.title),
      ),
      body: Center(
          child:
            Text(
              'Hello Flutter',
              style: new TextStyle(
                fontSize: 50,
                fontStyle:
                  FontStyle.italic,
                decoration:
                  TextDecoration.underline,
                color:
                  Colors.blue,
              )
            ),
      ),
    );
  }


}