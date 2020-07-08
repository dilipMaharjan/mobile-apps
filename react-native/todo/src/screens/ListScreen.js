import React from 'react';
import { View, Text, StyleSheet, FlatList } from 'react-native';
import ButtonScreen from './ButtonScreen';

const ListScreen = () => {
    const fruits = [
        { 'name': 'Apple' },
        { 'name': 'Banana' },
        { 'name': 'Mango' },
        { 'name': 'orange' },
        { 'name': 'Peach' },
        { 'name': 'Plum' },
        { 'name': 'Water melon' }
    ];
    return (
        <View>
            <ButtonScreen />
            <FlatList
                horizontal
                showsHorizontalScrollIndicator={false}
                keyExtractor={(fruit) => fruit.name}
                data={fruits}
                renderItem={({ item }) => {
                    return <Text style={styles.textStyle}>{item.name}</Text>
                }}
            />
            <FlatList
                keyExtractor={(fruit) => fruit.name}
                data={fruits}
                renderItem={({ item }) => {
                    return <Text style={styles.textStyleVertical}>{item.name}</Text>
                }}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    textStyle: {
        padding: 10
    },
    textStyleVertical: {
        marginVertical: 30
    }
});

export default ListScreen;