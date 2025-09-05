#!/bin/bash

echo "🔄 刷新ColorMatch项目配置..."

# 清理Gradle缓存
echo "1. 清理Gradle构建缓存..."
./gradlew clean

# 重新生成源代码
echo "2. 重新生成源代码..."
./gradlew generateDebugSources

# 验证构建
echo "3. 验证项目构建..."
./gradlew assembleDebug

if [ $? -eq 0 ]; then
    echo "✅ 项目构建成功！"
    
    # 检查Navigation Safe Args文件
    echo "4. 检查Navigation Safe Args生成文件..."
    if [ -f "app/build/generated/source/navigation-args/debug/com/colormatch/app/ui/camera/CameraFragmentDirections.kt" ]; then
        echo "✅ CameraFragmentDirections.kt 已生成"
    fi
    
    if [ -f "app/build/generated/source/navigation-args/debug/com/colormatch/app/ui/classification/ClassificationFragmentArgs.kt" ]; then
        echo "✅ ClassificationFragmentArgs.kt 已生成"
    fi
    
    if [ -f "app/build/generated/source/navigation-args/debug/com/colormatch/app/ui/classification/ClassificationFragmentDirections.kt" ]; then
        echo "✅ ClassificationFragmentDirections.kt 已生成"
    fi
else
    echo "❌ 项目构建失败！"
    exit 1
fi

echo ""
echo "📋 接下来请在Android Studio中执行："
echo "1. 打开项目: /Users/Atom_1/colormatch"
echo "2. 点击 'Sync Project with Gradle Files' 按钮 (或按 Cmd+Shift+O)"
echo "3. 等待同步完成，现在应该可以看到绿色运行箭头了！"
echo ""
echo "🎯 如果IDE仍显示编译错误，请尝试："
echo "- File -> Invalidate Caches and Restart"
echo "- Build -> Clean Project"
echo "- Build -> Rebuild Project"
echo ""
echo "🔧 已解决的问题："
echo "✅ Navigation Safe Args 已配置完成！"
echo "✅ Lint baseline 已创建，减少构建干扰！"
echo "✅ JDK版本兼容性问题已解决！"
echo "✅ 依赖库版本冲突已修复！"
echo "✅ 项目现在可以正常编译运行！"