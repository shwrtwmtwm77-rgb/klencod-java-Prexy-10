import React, { useState } from 'react';
import { 
  SafeAreaView, 
  Text, 
  StyleSheet, 
  View, 
  StatusBar, 
  Switch, 
  ScrollView 
} from 'react-native';

export default function App() {
  // حالات تفعيل الأدوات داخل واجهة Klencod IDE
  const [isFlyEnabled, setIsFlyEnabled] = useState(false);
  const [isAimEnabled, setIsAimEnabled] = useState(false);
  const [isEspEnabled, setIsEspEnabled] = useState(true);

  return (
    <SafeAreaView style={styles.container}>
      <StatusBar barStyle="light-content" backgroundColor="#0f172a" />
      
      <ScrollView contentContainerStyle={styles.scrollContainer}>
        {/* عنوان اللوحة */}
        <View style={styles.headerCard}>
          <Text style={styles.title}>Klencod IDE</Text>
          <Text style={styles.subtitle}>لوحة التحكم المركزية للأدوات والسكربتات</Text>
        </View>

        {/* قسم التحكم في الطيران */}
        <View style={styles.controlCard}>
          <View style={styles.row}>
            <Text style={styles.label}>🚀 تفعيل نظام الطيران (Flight)</Text>
            <Switch
              trackColor={{ false: '#334155', true: '#38bdf8' }}
              thumbColor={isFlyEnabled ? '#f8fafc' : '#94a3b8'}
              onValueChange={() => setIsFlyEnabled(previousState => !previousState)}
              value={isFlyEnabled}
            />
          </View>
          <Text style={styles.statusText}>
            الحالة: {isFlyEnabled ? 'مفعل وجاهز' : 'متوقف'}
          </Text>
        </View>

        {/* قسم التصويب الذكي */}
        <View style={styles.controlCard}>
          <View style={styles.row}>
            <Text style={styles.label}>🎯 التصويب الذكي (Smart Aim)</Text>
            <Switch
              trackColor={{ false: '#334155', true: '#38bdf8' }}
              thumbColor={isAimEnabled ? '#f8fafc' : '#94a3b8'}
              onValueChange={() => setIsAimEnabled(previousState => !previousState)}
              value={isAimEnabled}
            />
          </View>
          <Text style={styles.statusText}>
            الحالة: {isAimEnabled ? 'مفعل وجاهز' : 'متوقف'}
          </Text>
        </View>

        {/* قسم كشف الأماكن ESP */}
        <View style={styles.controlCard}>
          <View style={styles.row}>
            <Text style={styles.label}>👁️ كشف الأماكن (ESP Overlay)</Text>
            <Switch
              trackColor={{ false: '#334155', true: '#38bdf8' }}
              thumbColor={isEspEnabled ? '#f8fafc' : '#94a3b8'}
              onValueChange={() => setIsEspEnabled(previousState => !previousState)}
              value={isEspEnabled}
            />
          </View>
          <Text style={styles.statusText}>
            الحالة: {isEspEnabled ? 'مفعل وجاهز' : 'متوقف'}
          </Text>
        </View>

      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#0f172a',
  },
  scrollContainer: {
    padding: 20,
    alignItems: 'center',
  },
  headerCard: {
    width: '100%',
    padding: 20,
    borderRadius: 14,
    backgroundColor: '#1e293b',
    borderWidth: 1,
    borderColor: '#334155',
    alignItems: 'center',
    marginBottom: 20,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 4 },
    shadowOpacity: 0.3,
    shadowRadius: 4.65,
    elevation: 8,
  },
  title: {
    fontSize: 22,
    fontWeight: 'bold',
    color: '#38bdf8',
    marginBottom: 6,
  },
  subtitle: {
    fontSize: 13,
    color: '#94a3b8',
  },
  controlCard: {
    width: '100%',
    padding: 16,
    borderRadius: 12,
    backgroundColor: '#1e293b',
    borderWidth: 1,
    borderColor: '#334155',
    marginBottom: 15,
  },
  row: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: 8,
  },
  label: {
    fontSize: 15,
    fontWeight: '600',
    color: '#f8fafc',
  },
  statusText: {
    fontSize: 12,
    color: '#64748b',
  },
});
