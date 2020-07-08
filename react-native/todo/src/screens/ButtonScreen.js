import React from 'react';
import { Text, StyleSheet, View, Button } from 'react-native';
import { TouchableOpacity } from 'react-native-gesture-handler';

const ButtonScreen = () => {
    return (
        <View>
            <Button title="Tap me" style={styles.buttonTextSize} onPress={() => alert("Button Pressed")} />
            <TouchableOpacity onPress={() => alert("Touchable Opacity")}>
                <Text>Navigate To</Text>
            </TouchableOpacity>
        </View>
    );
}
const styles = StyleSheet.create({
    buttonTextSize: {
        fontSize: 30
    }
});
export default ButtonScreen;
