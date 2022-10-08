<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="描笔编号" prop="tracerPenId">
      <el-input v-model="dataForm.tracerPenId" placeholder="描笔编号"></el-input>
    </el-form-item>
    <el-form-item label="笔尖距离" prop="penNoseDistance">
      <el-input v-model="dataForm.penNoseDistance" placeholder="笔尖距离"></el-input>
    </el-form-item>
    <el-form-item label="描点深度" prop="pointDepth">
      <el-input v-model="dataForm.pointDepth" placeholder="描点深度"></el-input>
    </el-form-item>
    <el-form-item label="主轴转速" prop="shaftRotaion">
      <el-input v-model="dataForm.shaftRotaion" placeholder="主轴转速"></el-input>
    </el-form-item>
    <el-form-item label="进给速度" prop="shaftFeedRate">
      <el-input v-model="dataForm.shaftFeedRate" placeholder="进给速度"></el-input>
    </el-form-item>
    <el-form-item label="压脚压力" prop="presserForce">
      <el-input v-model="dataForm.presserForce" placeholder="压脚压力"></el-input>
    </el-form-item>
    <el-form-item label="快进速度" prop="rapidFeedRate">
      <el-input v-model="dataForm.rapidFeedRate" placeholder="快进速度"></el-input>
    </el-form-item>
    <el-form-item label="描点起始位置" prop="startPos">
      <el-input v-model="dataForm.startPos" placeholder="描点起始位置"></el-input>
    </el-form-item>
    <el-form-item label="刀库位置" prop="storehosePos">
      <el-input v-model="dataForm.storehosePos" placeholder="刀库位置"></el-input>
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
          tracerPenId: '',
          penNoseDistance: '',
          pointDepth: '',
          shaftRotaion: '',
          shaftFeedRate: '',
          presserForce: '',
          rapidFeedRate: '',
          startPos: '',
          storehosePos: ''
        },
        dataRule: {
          tracerPenId: [
            { required: true, message: '描笔编号不能为空', trigger: 'blur' }
          ],
          penNoseDistance: [
            { required: true, message: '笔尖距离不能为空', trigger: 'blur' }
          ],
          pointDepth: [
            { required: true, message: '描点深度不能为空', trigger: 'blur' }
          ],
          shaftRotaion: [
            { required: true, message: '主轴转速不能为空', trigger: 'blur' }
          ],
          shaftFeedRate: [
            { required: true, message: '进给速度不能为空', trigger: 'blur' }
          ],
          presserForce: [
            { required: true, message: '压脚压力不能为空', trigger: 'blur' }
          ],
          rapidFeedRate: [
            { required: true, message: '快进速度不能为空', trigger: 'blur' }
          ],
          startPos: [
            { required: true, message: '描点起始位置不能为空', trigger: 'blur' }
          ],
          storehosePos: [
            { required: true, message: '刀库位置不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/processParametersJqrzk/pointtracingprocess/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tracerPenId = data.pointTracingProcess.tracerPenId
                this.dataForm.penNoseDistance = data.pointTracingProcess.penNoseDistance
                this.dataForm.pointDepth = data.pointTracingProcess.pointDepth
                this.dataForm.shaftRotaion = data.pointTracingProcess.shaftRotaion
                this.dataForm.shaftFeedRate = data.pointTracingProcess.shaftFeedRate
                this.dataForm.presserForce = data.pointTracingProcess.presserForce
                this.dataForm.rapidFeedRate = data.pointTracingProcess.rapidFeedRate
                this.dataForm.startPos = data.pointTracingProcess.startPos
                this.dataForm.storehosePos = data.pointTracingProcess.storehosePos
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
              url: this.$http.adornUrl(`/processParametersJqrzk/pointtracingprocess/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'tracerPenId': this.dataForm.tracerPenId,
                'penNoseDistance': this.dataForm.penNoseDistance,
                'pointDepth': this.dataForm.pointDepth,
                'shaftRotaion': this.dataForm.shaftRotaion,
                'shaftFeedRate': this.dataForm.shaftFeedRate,
                'presserForce': this.dataForm.presserForce,
                'rapidFeedRate': this.dataForm.rapidFeedRate,
                'startPos': this.dataForm.startPos,
                'storehosePos': this.dataForm.storehosePos
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
