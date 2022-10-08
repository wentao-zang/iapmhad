<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="公称孔径" prop="aperture">
      <el-input v-model="dataForm.aperture" placeholder="公称孔径"></el-input>
    </el-form-item>
    <el-form-item label="刀具编号" prop="toolId">
      <el-input v-model="dataForm.toolId" placeholder="刀具编号"></el-input>
    </el-form-item>
    <el-form-item label="制孔深度" prop="holeDepth">
      <el-input v-model="dataForm.holeDepth" placeholder="制孔深度"></el-input>
    </el-form-item>
    <el-form-item label="锪窝深度" prop="dimpleDepth">
      <el-input v-model="dataForm.dimpleDepth" placeholder="锪窝深度"></el-input>
    </el-form-item>
    <el-form-item label="最大孔深" prop="holeDepthMax">
      <el-input v-model="dataForm.holeDepthMax" placeholder="最大孔深"></el-input>
    </el-form-item>
    <el-form-item label="最小孔深" prop="holeDepthMin">
      <el-input v-model="dataForm.holeDepthMin" placeholder="最小孔深"></el-input>
    </el-form-item>
    <el-form-item label="制孔主轴转速" prop="shaftRotaion">
      <el-input v-model="dataForm.shaftRotaion" placeholder="制孔主轴转速"></el-input>
    </el-form-item>
    <el-form-item label="制孔进给速度" prop="shaftFeedRate">
      <el-input v-model="dataForm.shaftFeedRate" placeholder="制孔进给速度"></el-input>
    </el-form-item>
    <el-form-item label="锪窝主轴转速" prop="dimpleRotation">
      <el-input v-model="dataForm.dimpleRotation" placeholder="锪窝主轴转速"></el-input>
    </el-form-item>
    <el-form-item label="锪窝进给速度" prop="dimpleFeedRate">
      <el-input v-model="dataForm.dimpleFeedRate" placeholder="锪窝进给速度"></el-input>
    </el-form-item>
    <el-form-item label="压脚压力" prop="presserForce">
      <el-input v-model="dataForm.presserForce" placeholder="压脚压力"></el-input>
    </el-form-item>
    <el-form-item label="快进速度" prop="rapidFeedRate">
      <el-input v-model="dataForm.rapidFeedRate" placeholder="快进速度"></el-input>
    </el-form-item>
    <el-form-item label="加工起始位置" prop="startPos">
      <el-input v-model="dataForm.startPos" placeholder="加工起始位置"></el-input>
    </el-form-item>
    <el-form-item label="第一刀加工深度" prop="firstDepth">
      <el-input v-model="dataForm.firstDepth" placeholder="第一刀加工深度"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          aperture: '',
          toolId: '',
          holeDepth: '',
          dimpleDepth: '',
          holeDepthMax: '',
          holeDepthMin: '',
          shaftRotaion: '',
          shaftFeedRate: '',
          dimpleRotation: '',
          dimpleFeedRate: '',
          presserForce: '',
          rapidFeedRate: '',
          startPos: '',
          firstDepth: ''
        },
        dataRule: {
          aperture: [
            { required: true, message: '公称孔径不能为空', trigger: 'blur' }
          ],
          toolId: [
            { required: true, message: '刀具编号不能为空', trigger: 'blur' }
          ],
          holeDepth: [
            { required: true, message: '制孔深度不能为空', trigger: 'blur' }
          ],
          dimpleDepth: [
            { required: true, message: '锪窝深度不能为空', trigger: 'blur' }
          ],
          holeDepthMax: [
            { required: true, message: '最大孔深不能为空', trigger: 'blur' }
          ],
          holeDepthMin: [
            { required: true, message: '最小孔深不能为空', trigger: 'blur' }
          ],
          shaftRotaion: [
            { required: true, message: '制孔主轴转速不能为空', trigger: 'blur' }
          ],
          shaftFeedRate: [
            { required: true, message: '制孔进给速度不能为空', trigger: 'blur' }
          ],
          dimpleRotation: [
            { required: true, message: '锪窝主轴转速不能为空', trigger: 'blur' }
          ],
          dimpleFeedRate: [
            { required: true, message: '锪窝进给速度不能为空', trigger: 'blur' }
          ],
          presserForce: [
            { required: true, message: '压脚压力不能为空', trigger: 'blur' }
          ],
          rapidFeedRate: [
            { required: true, message: '快进速度不能为空', trigger: 'blur' }
          ],
          startPos: [
            { required: true, message: '加工起始位置不能为空', trigger: 'blur' }
          ],
          firstDepth: [
            { required: true, message: '第一刀加工深度不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/processParametersJqrzk/coldextrusionholeprocess/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aperture = data.coldExtrusionHoleProcess.aperture
                this.dataForm.toolId = data.coldExtrusionHoleProcess.toolId
                this.dataForm.holeDepth = data.coldExtrusionHoleProcess.holeDepth
                this.dataForm.dimpleDepth = data.coldExtrusionHoleProcess.dimpleDepth
                this.dataForm.holeDepthMax = data.coldExtrusionHoleProcess.holeDepthMax
                this.dataForm.holeDepthMin = data.coldExtrusionHoleProcess.holeDepthMin
                this.dataForm.shaftRotaion = data.coldExtrusionHoleProcess.shaftRotaion
                this.dataForm.shaftFeedRate = data.coldExtrusionHoleProcess.shaftFeedRate
                this.dataForm.dimpleRotation = data.coldExtrusionHoleProcess.dimpleRotation
                this.dataForm.dimpleFeedRate = data.coldExtrusionHoleProcess.dimpleFeedRate
                this.dataForm.presserForce = data.coldExtrusionHoleProcess.presserForce
                this.dataForm.rapidFeedRate = data.coldExtrusionHoleProcess.rapidFeedRate
                this.dataForm.startPos = data.coldExtrusionHoleProcess.startPos
                this.dataForm.firstDepth = data.coldExtrusionHoleProcess.firstDepth
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/processParametersJqrzk/coldextrusionholeprocess/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aperture': this.dataForm.aperture,
                'toolId': this.dataForm.toolId,
                'holeDepth': this.dataForm.holeDepth,
                'dimpleDepth': this.dataForm.dimpleDepth,
                'holeDepthMax': this.dataForm.holeDepthMax,
                'holeDepthMin': this.dataForm.holeDepthMin,
                'shaftRotaion': this.dataForm.shaftRotaion,
                'shaftFeedRate': this.dataForm.shaftFeedRate,
                'dimpleRotation': this.dataForm.dimpleRotation,
                'dimpleFeedRate': this.dataForm.dimpleFeedRate,
                'presserForce': this.dataForm.presserForce,
                'rapidFeedRate': this.dataForm.rapidFeedRate,
                'startPos': this.dataForm.startPos,
                'firstDepth': this.dataForm.firstDepth
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
