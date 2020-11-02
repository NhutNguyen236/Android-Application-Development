/*Welcome back to my second ever app written in Flutter
* This app is about a a simple list view in Flutter*/
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final title = 'A very simple Flutter list view';

    return MaterialApp(
      title: title,
      home: Scaffold(
        appBar: AppBar(
          title: Text(title),
        ),
        /*This is how the story begins, call out ListView so you have a list view*/
        body: ListView(
          children: <Widget>[
            ListTile(
              leading: Icon(Icons.map),
              title: Text('Map'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.photo_album),
              title: Text('Album'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.phone),
              title: Text('Phone'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.add_a_photo),
              title: Text('Add a photo'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.add_call),
              title: Text('Add a call'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.add_photo_alternate),
              title: Text('Add a photo alternate'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.map),
              title: Text('Map'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.photo_album),
              title: Text('Album'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.phone),
              title: Text('Phone'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.add_a_photo),
              title: Text('Add a photo'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.add_call),
              title: Text('Add a call'),
              trailing: Icon(Icons.more_vert),
            ),
            ListTile(
              leading: Icon(Icons.add_photo_alternate),
              title: Text('Add a photo alternate'),
              trailing: Icon(Icons.more_vert),
            ),
          ],
        ),
      ),
    );
  }
}

/*As you can see, this is way too long, you just cannot sit around whole day, copy-paste ListTile
* Then we need adapter or sort of loop here
* Then it maybe later since the title of this app is a "simple list view" so no advanced things here yet*/

